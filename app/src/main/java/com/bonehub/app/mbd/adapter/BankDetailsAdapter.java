package com.bonehub.app.mbd.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bonehub.app.mbd.R;
import com.bonehub.app.mbd.roomdb.BankDetails;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class BankDetailsAdapter extends RecyclerView.Adapter<BankDetailsAdapter.BankDetailsHolder> {
    private OnItemClickListener listener;
    private List<BankDetails> bankDetails = new ArrayList<>();

    @NonNull
    @Override
    public BankDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bd_item_style, parent, false);
        return new BankDetailsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BankDetailsHolder holder, int position) {
        BankDetails currentBD = bankDetails.get(position);
        holder.bName.setText(currentBD.getBankName());
        holder.bBranch.setText(currentBD.getBankBranch());
        holder.bHolder.setText(currentBD.getAccountHolderName());
        holder.bAcNumber.setText(currentBD.getAccountNumber());
        holder.bifscCode.setText(currentBD.getIfscCode());
    }

    @Override
    public int getItemCount() {
        return bankDetails.size();
    }

    public void setNotes(List<BankDetails> bankDetails) {
        this.bankDetails = bankDetails;
        notifyDataSetChanged();
    }

    public BankDetails getBankDetailsAt(int adapterPosition) {

        return bankDetails.get(adapterPosition);
    }

    class BankDetailsHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView bName, bBranch, bHolder, bAcNumber, bifscCode;

        public BankDetailsHolder(@NonNull View itemView) {
            super(itemView);

            bName = itemView.findViewById(R.id.bankName_cs_tv);
            bBranch = itemView.findViewById(R.id.bankBranch_cs_tv);
            bHolder = itemView.findViewById(R.id.ac_holderName_cs_tv);
            bAcNumber = itemView.findViewById(R.id.accountNumber_cs_tv);
            bifscCode = itemView.findViewById(R.id.ifsc_code_cs_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getBankDetailsAt(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(BankDetails bankDetails);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
