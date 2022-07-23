#delete target directory
rm -rf target

#make directory named target
mkdir target

#copile all .java files
javac src/java/edu/school21/printer/*/*.java -d ./target

#launch java project
java -cp target edu.school21.printer.app.Program . 0 ../it.bmp