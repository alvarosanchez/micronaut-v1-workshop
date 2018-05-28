#!/bin/bash
set -x
git commit -a -m "Updated docs"
set -e
git push origin master

rm -rf /tmp/images

#Generate diagrams
asciidoctor -r asciidoctor-diagram -a generate-diagrams README.adoc

#Generate HTML
asciidoctor -a source-highlighter=pygments README.adoc

mv images /tmp

git checkout -f gh-pages
mv /tmp/images/* images/
mv README.html index.html
git add -A
git commit -m "Updated docs"
git push origin gh-pages
git checkout master