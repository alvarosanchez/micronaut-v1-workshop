#Generate diagrams
asciidoctor -r asciidoctor-diagram -a generate-diagrams README.adoc

#Generate HTML
asciidoctor -a source-highlighter=pygments README.adoc