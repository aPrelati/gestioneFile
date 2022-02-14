package com.example.gestionefile;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;

public class Gestore
{

    String nomeFile;

    public  String leggiFile(String nomeFile, Context c)
    {
        StringBuilder sb= new StringBuilder();
        try //file letto correttamente
        {
            BufferedReader fileIn= new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile)));
            String text="";
            while((text= fileIn.readLine())!= null){
                sb.append(text+"\n");
            }
        } catch (FileNotFoundException e) //il file non esiste
        {
            e.printStackTrace();
            Log.e("classe Gestore", "il file non esiste");
        } catch (IOException e) //impossibile leggere il file
        {
            Log.e("classe Gestore", "impossibile leggere il file");
        }
        return sb.toString();
    }

    public String scriviFile(String nomeFile, Context c)
    {
        String esito;
        FileOutputStream fileOutput;
        String textWrite= "Testo da scrivere";
        try //file apreto e chiuso correttamente
        {
            fileOutput= c.openFileOutput(nomeFile, Context.MODE_PRIVATE);
            fileOutput.write(textWrite.getBytes());
            fileOutput.close();
            esito="File scritto correttamente";
        } catch (FileNotFoundException e) //file non trovato
        {
            e.printStackTrace();
            Log.e("classe Gestore", "impossibile leggere il file in SCRITTURA");
            esito= "File non trovato";
        } catch (IOException e) //impossibile scrivere sul file
        {
            e.printStackTrace();
            Log.e("classe Gestore", "impossibile scivere sul file");
            esito= "Impossibile scrivere sul file";
        }

        return esito;
    }

}
