package com.bitex.shomoy.timesheet.service;

import com.bitex.shomoy.timesheet.entity.TimeSheetEntity;
import com.bitex.shomoy.timesheet.repository.TimeSheetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Neel Sinha (mailneelhere@gmail.com)
 * Date: 9/5/2018
 */
@Service
public class TimesheetServiceImpl implements TimeSheetRepository {
    @Override
    public <S extends TimeSheetEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends TimeSheetEntity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<TimeSheetEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<TimeSheetEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<TimeSheetEntity> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(TimeSheetEntity timeSheetEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends TimeSheetEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<TimeSheetEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TimeSheetEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<TimeSheetEntity> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public <S extends TimeSheetEntity> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public TimeSheetEntity saveAndFlush(TimeSheetEntity timeSheetEntity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<TimeSheetEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }
}
