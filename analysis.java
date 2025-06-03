import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.Collections;
public class analysis 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a filename:");
		
        //scan
		String fileName = input.nextLine();
		ArrayList<Book> books = new ArrayList<>();
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			fileScanner.nextLine();
			while(fileScanner.hasNextLine())
			{
				String[] parts = fileScanner.nextLine().split(",");
				try
				{
					double rating = Double.parseDouble(parts[2]);
					books.add(new Book(rating));
				}
				catch(NumberFormatException|ArrayIndexOutOfBoundsException e)
				{
					
				}
			}
		}
		
		
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR - File "+fileName+" not found");
		}
		histogram(books);
	}
		
		public static void histogram(ArrayList<Book> books)
		{
			if(books.isEmpty())
			{
				return;
			}
			ArrayList<Double> ratings = new ArrayList<>();
			for(Book b:books)
			{
				ratings.add(b.getRating());
			}
			double min = Collections.min(ratings);
			double max = Collections.max(ratings);
			TreeMap<Double,Integer> histogram = new TreeMap<>();
			for(double r = min;r<=max+0.001;r+=0.1)
			{
				histogram.put(Math.round(r*10.0)/10.0,0);
			}
			for(double r:ratings)
			{
				double key = Math.round(r*10.0)/10.0;
				histogram.put(key,histogram.getOrDefault(key,0)+1);
			}
			System.out.println("Histogram of Amazon Bestseller Ratings");
	        System.out.println("--------------------------------------");
	        
	        for(Map.Entry<Double,Integer> entry: histogram.entrySet())
	        {
	        	System.out.printf("%4.1f",entry.getKey());
	        	for(int i =0;i<entry.getValue();i++)
	        	{
	        		System.out.print("*");
	        	}
	        	System.out.println();
	        }
	        int count = ratings.size();
	        Collections.sort(ratings);
	        double median = count%2==1?ratings.get(count/2):(ratings.get(count/2)+ratings.get(count/2-1))/2.0;
	        double sum = 0;
	        for(double r: ratings)
	        {
	        	sum+=r;
	        }
	        double average = sum/count;
	        double sSum = 0;
	        for(double r: ratings)
	        {
	        	sSum+=Math.pow(r-average,2);
	        }
	        double stdSum = Math.sqrt(sSum/count);
	        System.out.println("Total books rated: "+count);
	        System.out.printf("Median score: %.1f\n",median);
	        System.out.printf("Average score: %.1f\n",average);
	        System.out.printf("Standard Deviation: %.2f\n",stdSum);
		}

}
