import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestRR {

    public static void main(String[] args) {


        String fileName;
        int quantum = 10;

        fileName = "RRtest.txt";

        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(fileName));

            List < Job > jobList = new ArrayList < Job > ();

            while ((sCurrentLine = br.readLine()) != null) {

                String a[] = sCurrentLine.split(","); // faz o split

                int processId = new Integer(a[0]);
                int arrivalTime = new Integer(a[1]);
                int cpuTime = new Integer(a[2]);

                Job job = new Job(processId, arrivalTime, cpuTime);

                jobList.add(job);

                //System.out.println(processId+" "+ arrivalTime+" " + cpuTime);
            }

            RoundRobin roundRobin = new RoundRobin();
            roundRobin.run(jobList, quantum);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}