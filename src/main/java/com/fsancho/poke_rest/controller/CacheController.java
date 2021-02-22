package com.fsancho.poke_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fernando Sancho
 *
 */
@RestController
@RequestMapping("api/caches")
public class CacheController {

	private CacheManager cacheManager;

	@Autowired
	public CacheController(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	@PatchMapping("/{name}")
	public void evictCache(@PathVariable String name) {
		Cache cache = this.cacheManager.getCache(name);
		if (cache != null) 
			cache.clear();
	}

}
