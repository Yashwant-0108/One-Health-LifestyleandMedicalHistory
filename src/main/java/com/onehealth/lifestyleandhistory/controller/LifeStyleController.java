package com.onehealth.lifestyleandhistory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onehealth.lifestyleandhistory.entity.LifeStyle;
import com.onehealth.lifestyleandhistory.exception.RecordNotFoundException;
import com.onehealth.lifestyleandhistory.service.LifeStyleService;

import java.util.List;

@RestController
@RequestMapping("/lifeStyleAndHistory/lifeStyle")
/**
 * The LifeStyleController class handles HTTP requests related to lifestyle information.
 */
public class LifeStyleController {

	@Autowired
	private LifeStyleService lifestyleService;
	
	/**
	 * Handles a GET request to the root endpoint.
	 * Returns a simple greeting message.
	 *
	 * @return A greeting message.
	 */
	@GetMapping
	public String Hello() {
		return "Hello from /lifeStyleAndHistory/lifeStyle/";
	}
	
	/**
	 * Handles a GET request to retrieve all lifestyles.
	 *
	 * @return A list of all lifestyles along with an appropriate HTTP status.
	 */
	@GetMapping("/all")
	public ResponseEntity<List<LifeStyle>> getAllLifestyles() {
		List<LifeStyle> lifestyles = lifestyleService.getAllLifeStyles();
		return new ResponseEntity<>(lifestyles, HttpStatus.OK);
	}

	/**
	 * Handles a GET request to retrieve a specific lifestyle by its serial number.
	 *
	 * @param lID The serial number of the lifestyle to retrieve.
	 * @return The retrieved lifestyle along with an appropriate HTTP status.
	 * @throws RecordNotFoundException If the specified lifestyle is not found.
	 */
	@GetMapping("/{lID}")
	public ResponseEntity<LifeStyle> getLifestyleBySNo(@PathVariable Long lID) throws RecordNotFoundException {
		LifeStyle lifestyle = lifestyleService.getLifestyleBylId(lID);
		return new ResponseEntity<>(lifestyle, HttpStatus.OK);
	}

	/**
	 * Handles a POST request to create a new lifestyle.
	 *
	 * @param lifestyle The lifestyle details to be created.
	 * @return A success message along with an appropriate HTTP status.
	 */
	@PostMapping
	public ResponseEntity<String> createLifestyle(@RequestBody LifeStyle lifestyle) {
		lifestyleService.createLifestyle(lifestyle);
		return new ResponseEntity<>(" LifeStyle Created Successfully", HttpStatus.CREATED);
	}

	/**
	 * Handles a PUT request to update an existing lifestyle.
	 *
	 * @param lID The serial number of the lifestyle to update.
	 * @param lifestyle The updated lifestyle details.
	 * @return A success message along with an appropriate HTTP status.
	 * @throws RecordNotFoundException If the specified lifestyle is not found.
	 */
	@PutMapping("/{lID}")
	public ResponseEntity<String> updateLifestyle(@PathVariable Long lID, @RequestBody LifeStyle lifestyle)
			throws RecordNotFoundException {
         lifestyleService.updateLifestyle(lID, lifestyle);
		return new ResponseEntity<>(" LifeStyle Updated Successfully", HttpStatus.OK);
	}

	/**
	 * Handles a DELETE request to delete a specific lifestyle by its serial number.
	 *
	 * @param lID The serial number of the lifestyle to delete.
	 * @return A success message along with an appropriate HTTP status.
	 * @throws RecordNotFoundException If the specified lifestyle is not found.
	 */
	@DeleteMapping("/{lID}")
	public ResponseEntity<String> deleteLifestyle(@PathVariable Long lID) throws RecordNotFoundException {
		lifestyleService.deleteLifestyle(lID);
		return new ResponseEntity<>(" LifeStyle Deleted Successfully",HttpStatus.OK);
	}
}
