package observerpattern;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ReverseHugeFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long startTime = System.nanoTime();
		 Path file = Paths.get("c:/triggerfullhinv.LOG");
		try {
			// Java 8: Stream class
			Stream<String> lines = Files.lines(file, StandardCharsets.UTF_8);

			for (String line : (Iterable<String>) lines::iterator) {
				 System.out.println(reverseString(line));
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		long endTime = System.nanoTime();
		long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
		System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
	}

	public static String reverseString(String s) {
		 String reversed = "";
		    for (int i = s.length() - 1;  0 <= i; i--) {
		        reversed += s.charAt(i);
		    }
		    return reversed;
		}
	

}
