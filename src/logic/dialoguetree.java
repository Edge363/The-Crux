package logic;

import java.util.Arrays;
import java.util.List;

public class dialoguetree {
	 GenericTreeNode<String> root = new GenericTreeNode<String>();
	 
	 dialoguetree(String inputText){
		 
		 List<String> rootText = game.keywordTagSearch(inputText,
					(List<String>) Arrays.asList(new String[] {"root"}));
		 
		 root=new GenericTreeNode<String>(rootText.get(0));
		 extractDialogueTree(inputText,root,"option");
	 }
	 
	 public void extractDialogueTree(String inputText,GenericTreeNode<String> root,String depthFirst){
		
		 for(int a=0;a<6;a++){
		 		List<String> children = game.keywordTagSearch(inputText,
				(List<String>) Arrays.asList(new String[] {depthFirst+a}));
		 		int B =0;
		   for(String child:children){
			   
			   List<String> optiontext = game.keywordTagSearch(child,
			   (List<String>) Arrays.asList(new String[] {"optiontext"}));
				 		
			   //Literally so not optimized it hurts. Don't stare at it.
			   List<String> response = game.keywordTagSearch(inputText,
						(List<String>) Arrays.asList(new String[] {"response"}));
			   
			  GenericTreeNode<String> optionTree =new GenericTreeNode<String>();
			  optionTree.setResponse(response.get(0));
			  optionTree.setOption(optiontext.get(0));
			  
			  extractDialogueTree(child,optionTree,depthFirst+B);
			  root.addChild(optionTree);
			   B++;
		   }
		   
		   }
		 }
	 }
	 


