package java_package;
import java.util.*;
public class Main {

	public static void main(String[] args){
		System.out.println("Notown Records");
		System.out.println("Which operation would you like to execute on the database :-");
		System.out.println("\t1. Add a musician");
		System.out.println("\t2. Remove a musician");
		System.out.println("\t3. Add an album");
		System.out.println("\t4. Remove an album");
		System.out.println("\t5. Add a song");
		System.out.println("\t6. Remove a song");
		System.out.println("\t7. Display all the tables");
		System.out.println("\n INPUT : ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		
		switch(input) {
		
		case 1 : 
			Ins_musician insert_musician = new Ins_musician();
			insert_musician.main();
			break;
			
		case 2 :
			del_musician delete_musician = new del_musician();
			delete_musician.main();
			break;
			
		case 3 :
			ins_album insert_album = new ins_album();
			insert_album.main();
			break;
			
		case 4 : 
			del_album delete_album= new del_album();
			delete_album.main();
			break;
			
		case 5 :
			ins_song insert_song = new ins_song();
			insert_song.main();
			break;
			
		case 6 :
			del_song delete_song = new del_song();
			delete_song.main();
			break;
			
		case 7 : 
			Get_info display_tables = new Get_info();
			display_tables.main();
			break;
			
		default :
			System.out.println("INVALID INPUT");
		}
		sc.close();
	}

}
