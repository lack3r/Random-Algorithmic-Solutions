package InterviewCake;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.xml.bind.DatatypeConverter;

public class DuplicateIdentifier {

	ArrayList<Path> filePaths;
	HashMapList<LocalFile, Path> mappedFiles;

	DuplicateIdentifier(){
		filePaths = new ArrayList<Path>();
		mappedFiles = new HashMapList<LocalFile, Path>();
	}
	class Path {
		String path;

		Path(String path) {
			this.path = path;
		}
	}

	class LocalFile implements Comparable{
		long size;
		String hash;
		byte[] digest;

		LocalFile(Path path) {
			computeHash(path);
			calculateSize(path);
		}
		private void calculateSize(Path path){
			File file =new File(path.path);
			
			if(file.exists()){
				size = file.length();
			}else{
				size = -1;
			}
		}
		private void computeHash(Path path) {
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("MD5");
				md.update(Files.readAllBytes(Paths.get(path.path)));
				digest = md.digest();
				this.hash = DatatypeConverter.printHexBinary(digest)
						.toUpperCase();
			} catch (NoSuchAlgorithmException | IOException e) {
				digest = null;
				this.hash = "(NULL): IO EXCEPTION";
				System.out.println("File: "+path.path+" could not be read");
				//e.printStackTrace();
			}
		}

		@Override
		public boolean equals(Object other) {
			boolean result = false;
			if (other instanceof LocalFile) {
				LocalFile that = (LocalFile) other;
				result = (this.hash.equals(that.hash));
			}
			return result;
		}

		@Override
		public int hashCode() {
			return hash.hashCode();
		}
		boolean compareTo(LocalFile lf){
			return this.size<lf.size;
		}
		@Override
		public int compareTo(Object arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	public void addFilePathsFromDirectory(String directory) {
		walk(directory);
		System.out.println(filePaths.size()+" files were added");
	}
	
	public void walk(String directory) {
		File root = new File( directory );
        File[] list = root.listFiles();

        if (list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
            	walk( f.getAbsolutePath() );
            }else{
            filePaths.add(new Path(f.getAbsoluteFile().getPath()));
            }
            }
	}
	///private String printSize(long size){
		/*long bytes = size;
		long kilobytes = (bytes / 1024);
		long megabytes = (kilobytes / 1024);
		long gigabytes = (megabytes / 1024);
		long terabytes = (gigabytes / 1024);
		
		return "bytes : " + bytes + 
				(kilobytes>0?"KB : " + kilobytes:"")+
				(megabytes>0?"MB : " + megabytes:"")+
				(gigabytes>0?"GB : " + gigabytes:"")+
				(terabytes>0?"TB : " + terabytes:"");*/
	//}
	public void createLocalFileHashMapList() {
		int i=1;
		for (Path path : filePaths) {
			System.out.println(i+"th file "+path.path);
			LocalFile file = new LocalFile(path);
			mappedFiles.put(file, path);
			i++;
		}
	}
	
	private void printList(ArrayList<Path> paths){
		int i=1;
		for (Path path:paths){
			System.out.print("\t"+i+": ");
			System.out.println(path.path);
			i++;
		}
	}
	
	public void printDuplicates(){
		System.out.println("PRINTING DUPLICATES");
		System.out.println("====================================");
		ArrayList<LocalFile> list = new ArrayList<LocalFile>();
		list.addAll(mappedFiles.keySet());
		Collections.sort(list);
		for (LocalFile file:mappedFiles.keySet()){
			ArrayList<Path> paths = mappedFiles.get(file);
			if (paths.size()>1){
				System.out.println("FILE: MD5: "+file.hash+ " File size: "+file.size+" bytes\t");
				printList(paths);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		String directory = "C:\\Users\\751909\\Desktop";
		DuplicateIdentifier di = new DuplicateIdentifier();
		di.addFilePathsFromDirectory(directory);
		di.createLocalFileHashMapList();
		di.printDuplicates();
	}

}
