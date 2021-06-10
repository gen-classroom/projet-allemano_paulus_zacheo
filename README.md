# GEN

## Installation 

#### Build and unzip the project 

You should now be able to run `statique`commands.

## Usage 

Executing `statique`  produce the following result:

```
statique
Usage: statique [COMMAND]
A brand new static site generator.
Commands:
  init   Initialize a static site directory
  clean  Clean a static site
  build  Build a static site
  serve  Serve a static site
  -version show version of the static site generator
```

**Init command :**

`statique init <path>` 

Initialize the site to the given path. It creates an **index.md** file and a **config.yaml** file.

**Build command** :

`statique build <path>`

This command creates the build directory in the given `path`. It converts all the markdown files present in the `path` to html files and copies them in build.

**Clean command :**

`statique clean <path>`

Deletes the build directory. The `path` should be the same as the one for `init`.

**Version :** 

`statique -version`

Show the version of the static site.

## Page format

The site's pages are written in Markdown. They can contain metadatas and standard content. The metadatas are identified by opening and closing `---`.

A typical page has the format  :

```
---
title: My page
author: The writer
date: 2021-03-10
---
# Title
## Subtitle

A standard text.

![a picture](./picture.png)
```

And is rendered in HTML like this :

```html
<h1>Title</h1>
<h2>Subtitle</h2>
<p>A standard text.</p>
<p><img src="./picture.png" alt="a picture" /></p>
```




