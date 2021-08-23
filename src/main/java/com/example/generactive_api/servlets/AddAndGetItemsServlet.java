package com.example.generactive_api.servlets;

import com.example.generactive_api.classes.db.Storage;
import com.example.generactive_api.classes.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "addingItemServlet", value = "/items/")
public class AddAndGetItemsServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader bf = req.getReader();
        StringBuilder body = new StringBuilder();
        while (bf.ready()) {
            body.append(bf.readLine());
        }
        Item item = objectMapper.readValue(body.toString(), Item.class);
        Storage.addItem(item);
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(objectMapper.writeValueAsString(item));
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        List<Item> items = Storage.getItemList();
        PrintWriter writer = resp.getWriter();
        writer.write(objectMapper.writeValueAsString(items));
    }

}