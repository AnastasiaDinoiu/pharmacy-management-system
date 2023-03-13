package com.bdproject.pharmacy.controller;

import com.bdproject.pharmacy.service.DiagnosesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DiagnoseController {

    private final DiagnosesService diagnosesService;
}
