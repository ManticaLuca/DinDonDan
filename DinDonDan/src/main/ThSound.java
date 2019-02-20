package main;

/**
 * @brief la classe gestisce i thread
 * @author Luca Mantica
 */
public class ThSound implements Runnable {

    /**
     * @brief stringa del {@link #sound}
     * @author Luca Mantica
     */
    private final String sound;
    private final SharedData sharedData;

    /**
     * @brief costruttore
     * @param sound stringa del {@link #sound}
     * @param sharedData dati condivisi
     * @author Luca Mantica
     */
    public ThSound(String sound, SharedData sharedData) {
        this.sound = sound;
        this.sharedData = sharedData;
    }

    /**
     * @brief run del thread
     * @author Luca Mantica
     */
    @Override
    public void run() {
        while (true) {
            if (Thread.interrupted()) {
                sharedData.SetFinito(sound);
                return;
            }
            sharedData.GetSchermo().GetSemaforo().Wait();
            sharedData.GetSchermo().GetBuffer().add(sound);
            sharedData.GetSchermo().GetSemaforo().Signal();
        }
       
    }

}
