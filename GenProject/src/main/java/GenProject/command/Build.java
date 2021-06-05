package GenProject.command;

import GenProject.utils.Converter;
import picocli.CommandLine;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;


@CommandLine.Command(name = "build",
        exitCodeOnExecutionException = 2,
        description = "Build a static site")
public class Build implements Runnable {
  @CommandLine.Parameters(description = "Path to site to build. (Must contain a config.json file)")
  String filePath;
  Converter converter;

  public void run() {

    Path path = Paths.get(filePath).normalize().toAbsolutePath();

    File buildDirectory = new File(path + "/build"); //craft new dir
    buildDirectory.mkdir();
    File filesDirectory = new File(path.toString()); //get all dir from path
    File configFile = new File(path+"/config.json");
    if (!configFile.exists()){
      throw new RuntimeException("Config file does not exist");
    }
    converter = new Converter(configFile);
    try {
      explore(filesDirectory, buildDirectory);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Get all the files and dir
  void explore(File filesDirectory, File buildDirectory) throws IOException {

    File[] listOfFiles = filesDirectory.listFiles();

    if (listOfFiles != null) {
      for (File file : listOfFiles) {
        String fileName = file.getName();
        if (fileName.contains(".md")) {//MD files become HTML files

          //Md2Html.convert(file, buildDirectory.toString());
          converter.markdownToHTML(file, buildDirectory.toString());
          File f1 = new File("./monSite/build/template/menu.html");
          FileReader fr = new FileReader(f1);
          BufferedReader br = new BufferedReader(fr);

          String name = fileName.substring(0,6);
          File f2 = null;
          if (fileName.equals("index.md")){
             f2 = new File("./monSite/build/index.html");
          }
          else {
             f2 = new File("./monSite/build/content/"+name+"html");
          }


          String str = "";
          String FileLayoutContent = "";
          while ((str = br.readLine() )!= null){
            FileLayoutContent += str;
          }
          if(name.equals("index.")){
            f1 = new File("./monSite/build/"+name+"html");
          }else{
            f1 = new File("./monSite/build/content/"+name+"html");
          }

          fr = new FileReader(f1);
          br = new BufferedReader(fr);
          str = "";
          String FileContent = "";
          while ((str = br.readLine() )!= null){
            FileContent += str;
          }

          String fin ="";
          String charset ="<meta charset=\"utf-8\">";
          boolean oneTime = false;
          boolean scdTime = false;
          for (int i = 0; i != FileContent.length();i++){
            fin += FileContent.charAt(i);
            if (FileContent.charAt(i)=='>' && FileContent.charAt(i-1)=='y' && !oneTime){
              fin+="\n";
              oneTime = true;
              for(int j = 0; j != FileLayoutContent.length();j++){
                fin+= FileLayoutContent.charAt(j);
                if (FileLayoutContent.charAt(j)=='>'){
                  fin+="\n";
                }
              }
            }
            if (FileContent.charAt(i)=='>' && FileContent.charAt(i-1)=='"' && !scdTime){
              fin+="\n";
              scdTime = true;
              for(int j = 0; j != charset.length();j++){
                fin += charset.charAt(j);
              }
            }
            if (FileContent.charAt(i)=='>'){
              fin+="\n";
            }
          }

          FileWriter fw = new FileWriter(f2);
          BufferedWriter bw = new BufferedWriter(fw);
          bw.write(fin);
          bw.flush();
          bw.close();
          fw.close();
          br.close();
          fr.close();

        } else if (!fileName.contains("config") && !file.isDirectory()) {
          File newDirectory = new File(buildDirectory + "/" + fileName);
          FileUtils.copyFile(file, newDirectory);
        } else if (file.isDirectory() && !fileName.contains("build")) {
          File newDirectory = new File(buildDirectory + "/" + fileName); //build new directory
          newDirectory.mkdir();
          explore(file, newDirectory);
        }
      }
    }
  }
}