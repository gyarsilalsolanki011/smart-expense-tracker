package com.gyarsilalsolanki011.expense.controller;

import com.gyarsilalsolanki011.expense.service.ExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/export")
@RequiredArgsConstructor
public class ExportController {
    private final ExportService exportService;

    @GetMapping("/excel")
    public ResponseEntity<InputStreamResource> downloadExcel(@AuthenticationPrincipal UserDetails user) throws IOException {
        ByteArrayInputStream stream = exportService.exportToExcel(user.getUsername());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=expenses.xlsx")
                .body(new InputStreamResource(stream));
    }

    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> downloadPdf(@AuthenticationPrincipal UserDetails user) throws IOException {
        ByteArrayInputStream stream = exportService.exportToPDF(user.getUsername());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=expenses.pdf")
                .body(new InputStreamResource(stream));
    }
}
