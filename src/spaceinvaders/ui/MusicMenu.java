package spaceinvaders.ui;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import spaceinvaders.exceptions.GameExceptions;

public class MusicMenu extends JMenu{
    
    private Clip currentClip;

    public MusicMenu()
    {
        super("Music");

        JMenuItem track1 = new JMenuItem("Faded- Alan Walker");
        JMenuItem track2= new JMenuItem("Minecraft Music");
        JMenuItem track3= new JMenuItem("Never Gonna Give You Up");
        JMenuItem custom= new JMenuItem("Custom Music");
        JMenuItem stopMusic= new JMenuItem("Stop Music");

        track1.addActionListener(e -> playMusic("/spaceinvaders/resources/Music/faded.wav"));
        track2.addActionListener(e -> playMusic("/spaceinvaders/resources/Music/minecraftmusic.wav"));
        track3.addActionListener(e -> playMusic("/spaceinvaders/resources/Music/nevergonnagiveyouup.wav"));
        custom.addActionListener(e -> chooseCustomMusic());
        stopMusic.addActionListener(e -> stopMusic());

        add(track1);
        add(track2);
        add(track3);
        add(custom);
        add(stopMusic);
            
        }

        public void playMusic(String path)
        {
            try {
                stopMusic();

                File file= new File("src"+ path);
                AudioInputStream audioStream;

                if(file.exists())
                {
                    audioStream= AudioSystem.getAudioInputStream(file);
                }
                else{
                    audioStream= AudioSystem.getAudioInputStream(MusicMenu.class.getResource(path));
                }
                currentClip = AudioSystem.getClip();
                currentClip.open(audioStream);
                currentClip.loop(Clip.LOOP_CONTINUOUSLY);
                currentClip.start();

            } catch (UnsupportedAudioFileException e) {
                GameExceptions.showErrorDialog("Unsupported audio format. Please use .wav files only.");
            } catch (IOException e) {
                GameExceptions.showErrorDialog("Error reading music file: " + e.getMessage());
            } catch (LineUnavailableException e) {
                GameExceptions.showErrorDialog("Audio system unavailable: " + e.getMessage());
            } catch (Exception e) {
                GameExceptions.showErrorDialog("Unexpected error playing music: " + e.getMessage());
            }
        }


        private void chooseCustomMusic() {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                if (!selectedFile.getName().toLowerCase().endsWith(".wav")) {
                    GameExceptions.showErrorDialog("Invalid file type. Only .wav files are supported.");
                    return;
                }

            playMusicFromFile(selectedFile);
        }
    }

        private void playMusicFromFile(File file) {
            try {
                stopMusic();

                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                currentClip = AudioSystem.getClip();
                currentClip.open(audioStream);
                currentClip.loop(Clip.LOOP_CONTINUOUSLY);
                currentClip.start();
            } catch (Exception e) {
                GameExceptions.showErrorDialog("Error playing custom music: " + e.getMessage());
            }
        }

        private void stopMusic() {
            if (currentClip != null && currentClip.isRunning()) {
                currentClip.stop();
                currentClip.close();
            
            }
        }
}


    

