package com.crystudios.contactlistsample.Data;

import com.crystudios.contactlistsample.Models.*;
import java.util.List;

public interface IReqresGetCallback {

    public abstract void LoadList(List<Users> list);
}
