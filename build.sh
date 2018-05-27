#!/bin/bash
git commit -a -m "Updated docs"
set -e
git push origin master

asciidoctor -r asciidoctor-diagram -a source-highlighter=pygments README.adoc
git checkout gh-pages
mv README.html index.html 
git commit -a -m "Updated docs"
git push origin gh-pages
git checkout master