package fastmarket.com.br.fastmarket.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fastmarket.com.br.fastmarket.R;

public class ProcuraFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public ProcuraFragment() {
        }

        public static fastmarket.com.br.fastmarket.fragment.ProcuraFragment newInstance(int sectionNumber) {
            fastmarket.com.br.fastmarket.fragment.ProcuraFragment fragment = new fastmarket.com.br.fastmarket.fragment.ProcuraFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_procura, container, false);
        }
    }
