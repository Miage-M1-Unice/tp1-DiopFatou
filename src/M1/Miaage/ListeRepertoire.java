package M1.Miaage;

import java.io.File;

public class ListeRepertoire {

		public static void contentDirectory(File f) {
				if(!f.isDirectory()) {
					System.err.println("l'objet en parametre doit etre un répertoire ");
				}
				else {
					for(String s: f.list()) {
						System.out.println(s);
					}
				}
		}
		
		public static void contentDirectory2(File f) {
			if(!f.exists() || !f.isDirectory()) {
				System.err.println("L'objet en parametre doit etre un répertoire existant !");
			}
			else {
				for(int i=0; i<f.listFiles().length; i++) {
					if(f.listFiles()[i].isFile()) {
						System.out.println("\t fichier: "+f.listFiles()[i].getName());
					}
					else {
						System.out.println("\t ==> répertoire: "+f.listFiles()[i].getName());
						for(int j=0; j<f.listFiles()[i].listFiles().length; j++) {
							if(f.listFiles()[i].listFiles()[j].isFile()) {
								System.out.println("\t \t fichier: "+f.listFiles()[i].listFiles()[j].getName());
							}
							else {
								contentDirectory2(f.listFiles()[i].listFiles()[j]);
							}
						}
					}
				}
			}
		}

		public static void contentDirectory3(File dir, String s) {
			if(!dir.isDirectory() || s==null) {
				System.err.println("L'objet en parametre doit etre un répertoire existant !");
			} else {
				System.out.println("==> repertoire: "+dir.getName());
				for(int i=0; i<dir.listFiles().length; i++) {
					if(dir.listFiles()[i].isFile()) {
						if(dir.listFiles()[i].getName().toLowerCase().endsWith(s))
							System.out.println("\t -> "+dir.listFiles()[i].getName());
					}
					else{
						System.out.println("\t ==> repertoire: "+dir.listFiles()[i].getName());
						for(int j=0; j<dir.listFiles()[i].listFiles().length; j++) {
							if(dir.listFiles()[i].listFiles()[j].isFile()) {
								if(dir.listFiles()[i].listFiles()[j].getName().toLowerCase().endsWith(s))
									System.out.println("\t \t -> "+dir.listFiles()[i].listFiles()[j].getName());
							}
							else {
								contentDirectory3(dir.listFiles()[i].listFiles()[j], s);
							}
						}
					}
				}
			}
		}
		
		public static void main(String[] args) {
			File f = new File("/Users/fatoudiop");
			ListeRepertoire.contentDirectory(f);
			ListeRepertoire.contentDirectory2(f);
			ListeRepertoire l1 = new ListeRepertoire();
			l1.contentDirectory3(f, ".java");

		}
}


