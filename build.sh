#!/bin/bash
git commit -a -m "Updated docs"
set -e
git push origin master

#Generate diagrams
asciidoctor -r asciidoctor-diagram -a generate-diagrams README.adoc

#Generate HTML
asciidoctor -a source-highlighter=pygments README.adoc

git checkout gh-pages
mv README.html index.html
mv *.png images/
git add -A
git commit -m "Updated docs"
git push origin gh-pages
git checkout master