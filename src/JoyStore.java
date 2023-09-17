import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class JoyStore {
    /*private String str1;
    private String str2;
    private String str3;*/
    public String[] ids;
    public String[] names;
    public int[] weights;
    private PriorityQueue<Joy> queueJoy;
    private int totalWeight;
    private Random rnd;


    public JoyStore(String str1, String str2, String str3) {
        /*this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;*/


        queueJoy = new PriorityQueue<>();
        rnd = new Random();

        String[] joy1 = str1.split((","));
        String[] joy2 = str2.split((","));
        String[] joy3 = str3.split((","));

        String[] ids = {joy1[0], joy2[0], joy3[0]};
        String[] names = {joy1[1], joy2[1], joy3[1]};
        int[] weights = {Integer.parseInt(joy1[2]), Integer.parseInt(joy2[2]), Integer.parseInt(joy3[2])};

        for (int item : weights) {
            totalWeight += item;
        }
        double frequency = 0;

        //int tw = Prepare(str1Internal, str2Internal, str3Internal);

        for (int i = 0; i < 10; i++) {

            double ddd = rnd.nextDouble();
            for (int j = 0; j < ids.length; j++) {
                frequency = (double) weights[j] / totalWeight;
                if (ddd < frequency) {
                    Joy toy = new Joy(ids[j], names[j], weights[j]);
                    queueJoy.offer(toy);
                }
            }
        }

        PriorityQueue<Joy> copiedQueue = new PriorityQueue<>(queueJoy); // копируем, чтобы эту очередь можно было
        // передать в метод printToFile, а то метод poll удаляет все элементы в предыдущем методе PrintPriorityQueue
        // MakeQueue(str1, str2, str3);
        PrintPriorityQueue(queueJoy); // для проверки работоспособности
        printToFile("Result.txt", copiedQueue);

    }

    public void PrintPriorityQueue(PriorityQueue pqueue) {
        int count = pqueue.size();
        int numerator = 0;
        for (int i = 0; i < count; i++) {
            Joy toy1 = (Joy) pqueue.poll();
            numerator++;
            System.out.println(numerator + ". id " + toy1.getId() + ", " + toy1.getName() + ", вес =  " + toy1.getWeight());
            // pqueue.offer(toy1);
        }
    }

    public void printToFile(String FileName, PriorityQueue queuePrint) {
        int count = queuePrint.size();
        int numerator = 0;
        try (FileWriter writer = new FileWriter(FileName);) {
            for (int i = 0; i < count; i++) {
                Joy toy2 = (Joy) queuePrint.poll();
                if (toy2 != null) {
                    numerator++;
                    writer.write(numerator + ". id " + toy2.getId() + ", " + toy2.getName() + ", вес =  " + toy2.getWeight() + "\n");
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }


    //    @Override
//    public String toString() {
//        for (int i = 0; i < 3; i++) {
//            Joy toy1 = (Joy) pqueue.peek();
//            // System.out.print(toy1.getId()+ ", " + toy1.getName() + ", вес =  " + toy1.getWeight());
//            return String.format("%s, %s, %s", toy1.getId(), toy1.getName(), toy1.getWeight());
//
//        }
//    }


}

