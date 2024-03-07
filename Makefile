# Options de compilation
JFLAGS = -g
# Compilateur Java
JC = javac
# Définition des suffixes des fichiers sources et compilés
.SUFFIXES: .java .class
# Règle implicite pour la compilation des fichiers .java en .class
.java.class:
	$(JC) $(JFLAGS) $*.java

# Liste des fichiers source Java
CLASSES = \
    Jeu.java \
	Fichier.java \
	Robot.java \
	Instruction.java \
	Level.java \
	Piece.java \
	Test.java     

# La cible par défaut, qui dépend de la cible "classes"
all: classes

# Règle pour la compilation des classes Java
classes:
	$(MAKE) $(CLASSES:.java=.class)

# Règle pour nettoyer les fichiers compilés
clean:
	$(RM) *.class

# Règle pour exécuter la classe "Jeu" en fonction de chaque niveau
run1: classes
	java Jeu 1

run2: classes
	java Jeu 2

run3: classes
	java Jeu 3
