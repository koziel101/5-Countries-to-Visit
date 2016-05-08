package com.example.hiago.fivecountriestovisit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hiago.relatoriodeestudos.R;

public class TabCanada extends Fragment {

    //Criando variáveis globais e estaticas para a barra de votacao e para o botao
    private static TextView textView;
    private static RatingBar ratingBar;
    private static String ratingBarS;
    Button buttonCanada;

    //Metodo getter para o número de estrelas selecionadas
    public static String getRatingBarS() {
        return ratingBarS;
    }

    /**
     * Metodo setter para o número de estrelas selecionadas
     *
     * @param ratingBarS: Parametro do tipo String da RatingBar
     */
    public static void setRatingBarS(String ratingBarS) {
        TabCanada.ratingBarS = ratingBarS;
    }

    //Ao criar a View, ela e inflada
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_canada, container, false);
        return view;
    }

    /**
     * Por se tratar de um fragment, os metodos do aplicativo precisam ser chamados atraves do
     * metodo do sistema "onActivityCreated"
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Chamando os métodos do aplicativo
        ListenerRating();
        enviarEmailCanada();
    }

    /**
     * Metodo responsavel por enviar o Intent de email
     */
    public void enviarEmailCanada() {
        buttonCanada = (Button) getActivity().findViewById(R.id.bttnCanada);

        //Cria um listener para um botao que vai diretamente na SettingsActivity
        buttonCanada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //verifica se o usuário ja realizou a classificacao do pais
                if (getRatingBarS() == null) {

                    //caso negativo, o sistema lanca um Toast
                    Toast.makeText(getContext().getApplicationContext(), "Você ainda não " +
                            "classificou este país", Toast.LENGTH_SHORT).show();

                } else {

                    //caso positivo, o sistema lanca um Intent de E-mail
                    EditText coment = (EditText) getActivity().findViewById(R.id.comentario_canada);
                    String comentario = null;
                    comentario = "Eu classifiquei o Canadá com " + getRatingBarS() + " / 5.0 estrelas \n";
                    comentario = comentario + coment.getText().toString();

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Avaliação sobre o Canadá");
                    intent.putExtra(Intent.EXTRA_TEXT, comentario);

                    //verifica se o sistema Android tem como receber Intents deste tipo
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }
        });
    }

    /**
     * Metodo da RatingBar --> A cada alteracao realizada na RatingBar, o sistema ira
     * pegar o novo dado que foi atualizado e atualizar no sistema
     * */
    public void ListenerRating() {
        ratingBar = (RatingBar) getActivity().findViewById(R.id.ratingBarCanada);
        textView = (TextView) getActivity().findViewById(R.id.avaliacaoCanada);

        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean f) {
                        textView.setText(String.valueOf(rating));

                        //Toda vez que o valor da RatingBar for atualizado, este valor sera
                        //salvo como String na variavel global ratingBarS
                        setRatingBarS(String.valueOf(rating));
                    }
                }
        );
    }
}