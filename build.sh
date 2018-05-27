#!/bin/bash
set -e
git commit -a -m "Updated docs"
git push origin master

asciidoctor README.adoc
git checkout gh-pages
mv README.html index.html 
git commit -a -m "Updated docs"
git push origin gh-pages
git checkout master