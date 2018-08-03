#! /bin/bash

clear

base_path=src/main/java
sources_path=ru/yura

cd $base_path

javac $sources_path/*.java
jar -cvfm MemoryCounter.jar $sources_path/manifest.mf $sources_path/*.class

rm $sources_path/*.class
echo '----------------------------------'


java -javaagent:MemoryCounter.jar ru.yura.Main
