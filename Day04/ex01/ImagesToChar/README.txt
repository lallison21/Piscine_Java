#remove target directory
rm -rf target

#create directory named target
mkdir target

#compile all .java files
javac `find . -name "*.java"` -d ./target

#copy resources folder to target directory
cp -R src/resources target/.

#create jar archive
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

#give permission jar archive to launch project
chmod 777 target/images-to-chars-printer.jar

#launch jar archive
java -jar target/images-to-chars-printer.jar . 0