package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.repository.TagJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kuba on 25. 4. 2016.
 */
@Transactional
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagJpaRepository tagJpaRepository;

}
