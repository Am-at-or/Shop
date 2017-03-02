package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.InternalMemoryDao;
import ua.com.shop.dto.form.InternalMemoryForm;
import ua.com.shop.entity.InternalMemory;
import ua.com.shop.service.InternalMemoryService;

@Service
public class InternalMemoryServiceImpl implements InternalMemoryService {

	@Autowired
	private InternalMemoryDao internalMemoryDao;

	@Override
	public void save(InternalMemoryForm form) {
		InternalMemory entity = new InternalMemory();
		entity.setId(form.getId());
		entity.setInternal(Integer.valueOf(form.getInternal()));
		internalMemoryDao.save(entity);
	}

	@Override
	public InternalMemory findOne(int id) {
		return internalMemoryDao.findOne(id);
	}

	@Override
	public List<InternalMemory> findAll() {
		return internalMemoryDao.findAll();
	}

	@Override
	public void delete(int id) {
		internalMemoryDao.delete(id);
	}

	@Override
	public void update(InternalMemory internalMemory) {
		internalMemoryDao.save(internalMemory);
	}

	@Override
	public InternalMemoryForm findForm(int id) {
		InternalMemoryForm form = new InternalMemoryForm();
		InternalMemory entity = internalMemoryDao.findOne(id);
		form.setId(entity.getId());
		form.setInternal(String.valueOf(entity.getInternal()));
		return form;
	}

	@Override
	public InternalMemory findUnique(String internal) {
		return internalMemoryDao.findUnique(Integer.valueOf(internal));
	}

}
