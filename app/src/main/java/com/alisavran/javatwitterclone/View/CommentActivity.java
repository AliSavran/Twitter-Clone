package com.alisavran.javatwitterclone.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alisavran.javatwitterclone.databinding.ActivityCommentBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class CommentActivity extends AppCompatActivity {

    private ActivityCommentBinding binding;
    private FirebaseAuth auth;
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCommentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    public void commentEditButtonClicked(View view) {
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            String email = user.getEmail();
            String comment = binding.commentEditText.getText().toString();

            HashMap<String, Object> postData = new HashMap<>();
            postData.put("useremail", email);
            postData.put("comment", comment);
            postData.put("date", FieldValue.serverTimestamp());

            firebaseFirestore.collection("Comments").add(postData)
                    .addOnSuccessListener(documentReference -> {
                        Toast.makeText(this, "Your comment has been added successfully", Toast.LENGTH_LONG).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    });
        }
    }
}
