package com.shoponthego;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CompositeFilter;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import com.shoponthego.offers.Offer;
import com.shoponthego.offers.OfferController;
import com.shoponthego.offers.OfferService;

@RunWith(SpringRunner.class)
public class OfferControllerTest {
	
	
	private MockMvc mockMvc;
	
	@Mock
	private OfferService offerService;
	
	@InjectMocks
	private OfferController offerController;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(offerController)
                .addFilters(new CompositeFilter())
                .build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllOffersShouldReturnAllOfferEntries() throws Exception {
		List<Offer> offers = Arrays.asList(
				new Offer("1592","Xbox 360","From 399 to 299","Active"),
				new Offer("2133","Playstation 3","You buy the console, we give you the second controller for free","Active"));
		
		when(offerService.getAllOffers()).thenReturn(offers);
		
		mockMvc.perform(get("/offers")).andExpect(status().isOk())
										.andExpect(jsonPath("$", hasSize(2)))
						                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
						                .andExpect(jsonPath("$[0].id", is("1592")))
						                .andExpect(jsonPath("$[0].title", is("Xbox 360")))
						                .andExpect(jsonPath("$[0].description", is("From 399 to 299")))
						                .andExpect(jsonPath("$[0].status", is("Active")))

						                .andExpect(jsonPath("$[1].id", is("2133")))
						                .andExpect(jsonPath("$[1].title", is("Playstation 3")))
						                .andExpect(jsonPath("$[1].description", is("You buy the console, we give you the second controller for free")))
						                .andExpect(jsonPath("$[1].status", is("Active")));
		
		verify(offerService, times(1)).getAllOffers();
        verifyNoMoreInteractions(offerService);
	}

	@Test
	public void testGetOfferById_OfferNotFound_ShouldReturnHttpStatusCode404() throws Exception {
		when(offerService.getOfferById("")).thenThrow(new NotFoundException());
		 
        mockMvc.perform(get("/offers/{id}", ""))
                .andExpect(status().isNotFound());
 
        verify(offerService, times(1)).getOfferById("");
        verifyNoMoreInteractions(offerService);
	}

	 @Test
	 public void getOfferById_OfferEntryFound_ShouldReturnFoundOfferEntry() throws Exception {
	        Offer offer = new Offer("2111","Playstation 3+Gift","FIFA 2018 in half prize","Active");
	 
	        when(offerService.getOfferById("2111")).thenReturn(offer);
	 
	        mockMvc.perform(get("/offers/{id}", "2111"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
	                .andExpect(jsonPath("$.id", is("2111")))
	                .andExpect(jsonPath("$.title", is("Playstation 3+Gift")))
	                .andExpect(jsonPath("$.description", is("FIFA 2018 in half prize")))
	                .andExpect(jsonPath("$.status", is("Active")));
	 
	        verify(offerService, times(1)).getOfferById("2111");
	        verifyNoMoreInteractions(offerService);
	    }
	 
	@Test
	public void testNewOfferEntry_ShouldAddOfferEntryAndReturnAddedEntry() throws IOException, Exception {
		Offer offer = new Offer("2111","Playstation 3+Gift","FIFA 2018 in half prize","Active");

        when(offerService.getOfferById("2111")).thenReturn(offer);
        
        mockMvc.perform(post("/offers").contentType(TestUtil.APPLICATION_JSON_UTF8)
        				                .content(TestUtil.convertObjectToJsonBytes(offer)))
        .andExpect(status().isOk())
        .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.id", is("2111")))
        .andExpect(jsonPath("$.title", is("Playstation 3+Gift")))
        .andExpect(jsonPath("$.description", is("FIFA 2018 in half prize")))
        .andExpect(jsonPath("$.status", is("Active"))); 
		
	}

	@Test
	public void testUpdateOffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOffer() {
		fail("Not yet implemented");
	}

}
