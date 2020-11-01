Main.class: Main.java ReadWrite.class User.class Level.class Accumulator.class Register.class Code.class Opcode.class Operand.class
	javac -g Main.java

ReadWrite.class: ReadWrite.java User.class Accumulator.class Register.class Level.class Code.class
	javac -g ReadWrite.java

Operand.class: Operand.java Code.class
	javac -g Operand.java

Opcode.class: Opcode.java Code.class
	javac -g Opcode.java

User.class: User.java Level.class
	javac -g User.java 

Accumulator.class: Accumulator.java
	javac -g Accumulator.java

Register.class: Register.java
	javac -g Register.java

Level.class: Level.java Code.class
	javac -g Level.java

Code.class: Code.java
	javac -g Code.java

clean:
	rm *.class

run: Main.class
	java Main

debug: Main.class
	jdb Main


