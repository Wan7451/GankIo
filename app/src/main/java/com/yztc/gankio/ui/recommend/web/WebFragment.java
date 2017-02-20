package com.yztc.gankio.ui.recommend.web;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.yztc.gankio.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebFragment extends Fragment {


    public WebFragment() {
        // Required empty public constructor
    }

    public static WebFragment getInstance(String title, String content) {
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("content", content);
        WebFragment fragment = new WebFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String content = getArguments().getString("content");
        String title = getArguments().getString("title");
        TextView textView = (TextView) view.findViewById(R.id.title);
        textView.setText(title);
        WebView webView = (WebView) view.findViewById(R.id.webView);
        WebSettings settings = webView.getSettings();
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);


        StringBuffer buffer = new StringBuffer();
        buffer.append("<html>");
        buffer.append("<head>");
        buffer.append("<meta name=\\\"viewport\\\" content=\\\"initial-scale=1, initial-scale=1.0, user-scalable=no\\\">");
        buffer.append("<style>img{max-width: 100%; width:auto; height:auto;}</style>");
        buffer.append("</head>");
        buffer.append("<body>");
        buffer.append(content);
        buffer.append("</body></html>");


        webView.loadDataWithBaseURL("", buffer.toString(), "text/html; charset=utf-8", "utf-8", "");

    }
}
