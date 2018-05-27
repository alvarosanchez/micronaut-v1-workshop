#!/bin/bash
git add *.png
git commit -a -m "Updated docs"
set -e
git push origin master

asciidoctor -r asciidoctor-diagram -a source-highlighter=pygments -a generate-diagrams README.adoc
git checkout gh-pages
mv README.html index.html
mv *.png images/
git commit -a -m "Updated docs"
git push origin gh-pages
git checkout master