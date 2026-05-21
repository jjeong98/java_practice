package etc.fileio.repository;

import oop.stream.domain.LearningActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * 특정 타입의 학습 활동만 담는 제네릭 레포지토리
 */
public class ActivityRepository<T extends LearningActivity> {
	
	private final List<T> storage = new ArrayList<>();
	
	public void add(T activity) {
		if (activity == null) {
			throw new IllegalArgumentException("Activity cannot be null");
		}
		storage.add(activity);
	}
	
	//저장된 모든 활동을 반환
	public List<T> findAll() {
		return Collections.unmodifiableList(storage);
	}
	
	// 조건에 맞는 활동들만
	public List<T> filter(Predicate<T> predicate) {
		List<T> result = new ArrayList<>();
		for (T activity : storage) {
			if (predicate.test(activity)) {
				result.add(activity);
			}
		}
		return result;
	}
	
	
	// 조건에 맞는 1st 활동들만
	public Optional<T> findFirst(Predicate<T> predicate) {
		for (T activity : storage) {
			if (predicate.test(activity)) {
				return Optional.of(activity);
			}
		}
		return  Optional.empty();
	}
	
	public int count() {
		return storage.size();
	}
	
	public int getTotalMinutes() {
		int totalMinutes = 0;
		for (T activity : storage) {
			totalMinutes += activity.getMinutes();
		} return totalMinutes;
	}
	
	
	
}
