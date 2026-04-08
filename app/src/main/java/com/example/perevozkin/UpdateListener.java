package com.example.perevozkin;

import androidx.fragment.app.Fragment;

public interface UpdateListener {
    void onUpdateText(String newText);
    void onFragmentSwitch(int container_id, Fragment newFragment);
}
