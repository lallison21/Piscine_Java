#remove target and lib folder
rm -rf target lib

#create directory named target
mkdir target lib

#download .jar library
touch lib/jcommander-1.82.jar
touch lib/JCDP-4.0.2.jar
curl -o lib/jcommander-1.82.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar
curl -o lib/JCDP-4.0.2.jar https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.2/JCDP-4.0.2.jar

#compile all .java files
javac -cp lib/JCDP-4.0.2.jar:lib/jcommander-1.82.jar:. `find . -name "*.java"` -d target

#copy resources folder to target directory
cp -R src/resources target/.

#unpack .jar library:
jar -xf lib/jcommander-1.82.jar
jar -xf lib/JCDP-4.0.2.jar
rm -rf META-INF
mv com target

#create jar archive
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

#give permission jar archive to launch project
chmod 777 target/images-to-chars-printer.jar

#launch jar archive
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN
