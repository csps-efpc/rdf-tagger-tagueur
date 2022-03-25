# RDF tagger / tagueur

Self-Contained RDF Tagger - Tagueur autonome RDF

This project is an experiment from a PSX demonstration project exploring ways 
to minimize the human effort to add data to a resource domain when one can't 
change the subject resources themselves.

Presented with a set of subject URLs, predicate URIs and object URIs, it enables 
subject matter experts to link them using a touch-friendly UI. 

A further constraint is that the application needed to be able to run in any
environment without depending on connectivity to a server, and that the output 
needed to be standards-based, and versionable.

Ce projet est une expérience d'un projet de démonstration PSX explorant les moyens
pour minimiser l'effort humain pour ajouter des données à un domaine de ressources quand on ne peut pas
changer les ressources du sujet eux-mêmes.

Présenté avec un ensemble d'URL de sujet, d'URI de prédicat et d'URI d'objet, il permet
experts en la matière pour les relier à l'aide d'une interface utilisateur tactile.

Une autre contrainte est que l'application devait pouvoir s'exécuter dans n'importe quel
environnement sans dépendre de la connectivité à un serveur, et que la sortie
devaient être basés sur des normes et versionnables.

## Build:
Build requires Maven and a Java 17 JDK to build and a Java 17 runtime. Azul 
Zulu is recommended, although just about any compliant JDK will work -- be 
aware of licensing restrictions! 

La compilation nécessite Maven et un JDK Java 17 et un runtime Java 17. Azul
Zulu est recommandé, bien que n'importe quel JDK compatible fonctionnera - soyez
conscient des restrictions de licence !

https://www.azul.com/downloads/zulu-community/

```
cd rdftagger
mvn clean install
```

## Usage:
```
java -jar target/rdftagger-*-bin.jar [subject file] [predicate file] [object file]
```

The subject, predicate, and object files are UTF-8 encoded tab-separated values 
files or CSV files, in which the first column is the URI of the subject, 
predicate, or object, and the optional second column is a human-readable label for the given 
URI.

The subjects are treated as URLs, and used to load content into the viewing pane.

The objects are listed as buttons in the left-hand pane. Pressing each button 
cycles through the predicates that can link the current subject to the object, 
with an additional state being "no predicate". 

This model was most effective with a very large list of subjects, a list of 1-4 
predicates, and between 1 and 10 objects.

This model was not selected for deployment because the set of objects for the 
demonstration project grew into a list of several hundred.

Les fichiers sujet, prédicat et objet sont des fichiers TSV ou CSV encodés en 
UTF-8, dans lesquels la première colonne est l'URI du sujet, prédicat, ou objet,
et la deuxième colonne facultative est une étiquette lisible par l'homme pour 
l'URI donné.

Les sujets sont traités comme des URL et utilisés pour charger le contenu dans 
le volet de visualisation.

Les objets sont répertoriés sous forme de boutons dans le volet de gauche. En 
appuyant sur chaque bouton, on parcourt les prédicats qui peuvent lier le sujet
courant à l'objet, avec un état supplémentaire étant "aucun prédicat".

Ce modèle était le plus efficace avec une très grande liste de sujets, une 
liste de 1 à 4 prédicats, et entre 1 et 10 objets.

Ce modèle n'a pas été sélectionné pour le déploiement car l'ensemble d'objets 
pour le projet de démonstration est devenu une liste de plusieurs centaines.

Authors: Joshua Turner

## Pending enhancements:

* I18n - would only need to replace the labels in the FXML declaration with i18n
references and then create standard Java I18n files.
* Object organization - Figure out a usable way to make the set of objects 
navigable in the left-hand pane so that more can be tackled at a time. There's a 
critical tradeoff in cognitive load for users. It might be easier to just 
organize work so a subject matter expert only needs to work on a few objects at 
a time.
* Auto-save
* Left-handed/Right-handed mode
* Load an existing Turtle file on start-up, so that users can pause and resume 
work. This would be particularly useful with auto-save.