package ua.com.shop.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriter {

	enum Folder {
		PHONE
	}

	boolean write(Folder folder, MultipartFile file, Integer id);
}