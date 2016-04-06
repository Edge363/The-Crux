package logic;

public class dialogueBot {
	 GenericTree<String> dialogueTree = new GenericTree<String>();
	 GenericTreeNode<String> root = new GenericTreeNode<String>();
	 GenericTreeNode<String> currentSpeechOptions = new GenericTreeNode<String>();
	 
	 dialogueBot(){
	 dialogueTree.setRoot(root);
	 }
	 
}