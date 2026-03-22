package bai05.business;

import bai05.dao.DoctorDAO;
import bai05.model.Doctor;

import java.util.List;

public class DoctorService {
    private DoctorDAO dao = new DoctorDAO();

    public void showDoctors() {
        List<Doctor> list = dao.getAllDoctors();
        for (Doctor d : list) {
            System.out.println(
                    d.getId() + " | " + d.getName() + " | " + d.getSpecialty()
            );
        }
    }

    public void addDoctor(String id, String name, String specialty) {
        Doctor d = new Doctor(id, name, specialty);
        if (dao.addDoctor(d)) {
            System.out.println("Thêm bác sĩ thành công!");
        }
    }

    public void statisticBySpecialty() {
        dao.countBySpecialty();
    }
}
