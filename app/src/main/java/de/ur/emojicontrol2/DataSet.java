package de.ur.emojicontrol2;

/**
 * Created by Aend on 15.05.2017.
 */

public class DataSet
{
    public String Emotion;
    public String PosNeg;
    public double Intensity;
    public double Auslöser_Vergangenheit;
    public double Auslöser_Zukunft;
    public double Auslöser_jetzt;
    public double Auslöser_Selbst_Andere;
    public double Auslöser_Kontrollierbarkeit;
    public double Mimik_Gestik;
    public  double Verbale_Äußerung;
    public  double Verhaltensimpuls_nachgebend;
    public  double Anspannung;
    public double Tendenz;
    public double Aufmerksamkeit;
    public double Situation_verlassen;
    public double Situation_verändern;
    public double Situation_umdeuten;
    public double Versucht_abzulenken;
    public double Substanz_konsumiert;
    public double Lange_nachgegrübelt;
    public double Resigniert_abgewartet;
    public double Gefühl_genossen;
    public double Ereignisse_vorgestellt;
    public double Gefühl_nicht_fortbestehen;
    public double Situation_verbessern;



    public DataSet()
    {}

    public DataSet(
            String Emotion,
            String PosNeg,
            double Intensity,
            double Auslöser_Zukunft,
            double Auslöser_jetzt,
            double Auslöser_Vergangenheit,
            double Auslöser_Selbst_Andere,
            double Auslöser_Kontrollierbarkeit,
            double Mimik_Gestik,
            double Verbale_Äußerung,
            double Verhaltensimpuls_nachgebend,
            double Anspannung,
            double Tendenz,
            double Aufmerksamkeit,
            double Situation_verlassen,
            double Situation_verändern,
            double Situation_umdeuten,
            double Versucht_abzulenken,
            double Substanz_konsumiert,
            double Lange_nachgegrübelt,
            double Resigniert_abgewartet,
            double Gefühl_genossen,
            double Ereignisse_vorgestellt,
            double Gefühl_nicht_fortbestehen,
            double Situation_verbessern

            )
    {
        this.Emotion=Emotion;
        this.Intensity=Intensity;
        this.PosNeg=PosNeg;
        this.Auslöser_Vergangenheit = Auslöser_Vergangenheit;
        this.Auslöser_jetzt =Auslöser_jetzt ;
        this.Auslöser_Zukunft =Auslöser_Zukunft ;
        this.Auslöser_Selbst_Andere =Auslöser_Selbst_Andere ;
        this.Auslöser_Kontrollierbarkeit =Auslöser_Kontrollierbarkeit ;
        this.Mimik_Gestik =Mimik_Gestik ;
        this.Verbale_Äußerung =Verbale_Äußerung ;
        this.Verhaltensimpuls_nachgebend =Verhaltensimpuls_nachgebend ;
        this.Anspannung =Anspannung ;
        this.Tendenz =Tendenz ;
        this.Aufmerksamkeit =Aufmerksamkeit ;
        this.Situation_verlassen =Situation_verlassen ;
        this.Situation_verändern =Situation_verändern ;
        this.Situation_umdeuten =Situation_umdeuten ;
        this.Versucht_abzulenken =Versucht_abzulenken ;
        this.Substanz_konsumiert = Substanz_konsumiert;
        this.Lange_nachgegrübelt =Lange_nachgegrübelt ;
        this.Resigniert_abgewartet =Resigniert_abgewartet ;
        this.Gefühl_genossen =Gefühl_genossen ;
        this.Ereignisse_vorgestellt =Ereignisse_vorgestellt ;
        this.Gefühl_nicht_fortbestehen =Gefühl_nicht_fortbestehen ;
        this.Situation_verbessern =Situation_verbessern ;


    }

}
