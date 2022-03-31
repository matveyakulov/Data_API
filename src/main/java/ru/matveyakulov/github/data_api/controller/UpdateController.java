package ru.matveyakulov.github.data_api.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matveyakulov.github.data_api.dto.UpdateTableDataDTO;
import ru.matveyakulov.github.data_api.service.UpdateService;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/app")
public class UpdateController {

   private UpdateService updateService;

    @PreAuthorize("hasAnyRole('USER')")
    @PutMapping("/update")
    public ResponseEntity<?> updateData(@RequestBody UpdateTableDataDTO updateTableDataDTO){
        updateService.update(updateTableDataDTO);
        return ResponseEntity.ok().build();
    }
}
