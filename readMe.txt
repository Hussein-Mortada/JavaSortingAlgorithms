completeness: 100%
List of known deficiencies:
none

How to run:
Enter the command prompt in the correct directory.  Type "java -jar (sort.jar) -t<?> -f<?> -s<?>"
sort.jar will be typed if the command prompt is already in the directory with the jar file, otherwise
specify the path to the jar file

<?> will determine what you put there
for the following:
-t<h,b,v> -t is what the shapes will be compared by. h for height sorting b for base area sorting v for volume sorting
-s<i,b,s,q,m,z> -s is for sorting algorithm.  i for insertion sort, s for selection, b for bubble, q for quick, m for merge, z for heap sort.  any other letter will cause the application to not run
-f for file type .  Following the -f will be the direct path to the text file of shapes to sort. any incorrect file path will result in application not running

Note that all command line arguments are case insensitive and order of arguments is insensitive
