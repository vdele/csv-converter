package com.vdel.bo.orga;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Hello world!
 *
 */
public class App
{

    public static class Auto implements Serializable {
        String nom;
        String marque;

    }

    public static void main( final String[] args )
    {

        String a = null;
        a = readTransactionID();

        saveTransactionId(a);

    }

    private static String readTransactionID() {
        String transactionId = null;
        ObjectInputStream input = null;
        final File file = new File("toto.sav");
        if (file.exists()) {
            try {
                System.out.println("Fichier existe");
                input = new ObjectInputStream(new FileInputStream(file));
                transactionId = (String) input.readObject();
                System.out.println("Content : \n" + transactionId + "\n-----------");
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
            } catch (final IOException e) {
                e.printStackTrace();
            } catch (final ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("fichier non trouvé");
        }

        return transactionId;
    }

    private static void saveTransactionId(final Object transactionId) {
        String whatIWantToAdd = (String) transactionId;
        if (whatIWantToAdd != null) {
            whatIWantToAdd = whatIWantToAdd + "\n123456789";

        } else {
            whatIWantToAdd = "first";
        }
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream("toto.sav"));
            output.writeObject(whatIWantToAdd);
            output.close();
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }

    }

    double a;

    void setA(final double b) {
        a = b;
    }
}
