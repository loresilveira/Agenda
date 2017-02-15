package br.com.galdir.agenda2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import br.com.galdir.agenda2.modelo.Aluno;

/**
 * Created by Lore on 07/02/2017.
 */
public class FormularioHelper {

    private final EditText campoFormNome;
    private final EditText campoFormEndereco;
    private final EditText campoFormTelefone;
    private final EditText campoFormSite;
    private final EditText campoFormEmail;
    private final RatingBar campoFormNota;
    private final ImageView campoFormFoto;
    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity) {
       campoFormNome = (EditText) activity.findViewById(R.id.formulario_nome);
       campoFormEndereco = (EditText) activity.findViewById(R.id.formulario_endereco);
       campoFormTelefone = (EditText) activity.findViewById(R.id.formulario_telefone);
       campoFormEmail = (EditText) activity.findViewById(R.id.formulario_email);
       campoFormSite = (EditText) activity.findViewById(R.id.formulario_site);
       campoFormNota = (RatingBar) activity.findViewById(R.id.formulario_nota);
        campoFormFoto = (ImageView) activity.findViewById(R.id.formulario_foto);
       aluno = new Aluno();
    }

    public Aluno pegaAluno(){

        aluno.setNome(campoFormNome.getText().toString());
        aluno.setEndereco(campoFormEndereco.getText().toString());
        aluno.setTelefone(campoFormTelefone.getText().toString());
        aluno.setEmail(campoFormEmail.getText().toString());
        aluno.setSite(campoFormSite.getText().toString());
        aluno.setNota(Double.valueOf(campoFormNota.getProgress()));
        aluno.setCaminhoFoto((String)campoFormFoto.getTag());

        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        this.aluno = aluno;
        campoFormNome.setText(aluno.getNome());
        campoFormEndereco.setText(aluno.getEndereco());
        campoFormTelefone.setText(aluno.getTelefone());
        campoFormSite.setText(aluno.getSite());
        campoFormEmail.setText(aluno.getEmail());
        carregaFoto(aluno.getCaminhoFoto());
        this.campoFormNota.setProgress(this.aluno.getNota().intValue());

    }

    public void carregaFoto(String caminhoFoto) {
        if (caminhoFoto != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
            campoFormFoto.setImageBitmap(bitmapReduzido);
            campoFormFoto.setScaleType(ImageView.ScaleType.FIT_XY);
            campoFormFoto.setTag(caminhoFoto);
        }
    }
}
