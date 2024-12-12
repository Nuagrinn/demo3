package org.multithreading.chicken;

public class ChickenVoice {

    static EggVoice mAnotherOpinion;	//Побочный поток

    public static void main(String[] args)
    {
        mAnotherOpinion = new EggVoice();	//Создание потока
        System.out.println("Спор начат...");
        mAnotherOpinion.start(); 			//Запуск потока

        for(int i = 0; i < 5; i++)
        {
            try{
                Thread.sleep(1000);		//Приостанавливает поток на 1 секунду
            }catch(InterruptedException e){}

            System.out.println("курица!");
        }

        //Слово «курица» сказано 5 раз

        if (mAnotherOpinion.isAlive()) {
            try {
                mAnotherOpinion.join();
            } catch (InterruptedException ignored){
            }
            System.out.println("Первым появилось яйцо!");
        } else {
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор закончен!");
    }


    static class EggVoice  extends Thread {
        @Override
        public void run()
        {
            for(int i = 0; i < 5; i++)
            {
                try{
                    sleep(1000);		//Приостанавливает поток на 1 секунду
                }catch(InterruptedException e){}

                System.out.println("яйцо!");
            }
            //Слово «яйцо» сказано 5 раз
        }
    }
}
