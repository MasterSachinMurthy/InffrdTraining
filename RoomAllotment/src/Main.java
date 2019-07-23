

import java.util.Arrays;

class Main {



    int av;
    static int findRoom(int start[], int end[], int n)
    {

        Arrays.sort(start);
        Arrays.sort(end);                                                                   // Sorting the arrays in ascending order of time


        int rooms = 1, result = 1;
        int index_start = 1, index_end = 0;


        while (index_start < n && index_end < n)
        {

            if (start[index_start] < end[index_end])                                        // Condition checks if start time is lesser than the end times

            {
                rooms++;
                index_start++;


                if (rooms > result)                                                         // A room is allocated for each start time
                    result = rooms;
            }


            else
            {
                rooms--;                                                                    // A room is de-allocated each time and end time is encountered which means that a class is over
                index_end++;
            }
        }

        return result;
    }


    public static void main(String[] args)
    {
        int start[] = {30,0,50,0};                                  // All start times

        int end[] = {50,50,60,200};                                // All end times
        int n = start.length;
        System.out.println("Minimum Number of Rooms Required = "
                + findRoom(start, end, n));
    }
}
