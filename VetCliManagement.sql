PGDMP  4                    |            VetClinicManagement    16.2    16.2 G    ,           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            -           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            .           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            /           1262    25561    VetClinicManagement    DATABASE     �   CREATE DATABASE "VetClinicManagement" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
 %   DROP DATABASE "VetClinicManagement";
                postgres    false            �            1259    25564    animals    TABLE     W  CREATE TABLE public.animals (
    animal_id bigint NOT NULL,
    animal_breed character varying(255),
    animal_colour character varying(255),
    animal_date_of_birth date,
    animal_gender character varying(255),
    animal_name character varying(255),
    animal_species character varying(255),
    animal_customer_id integer NOT NULL
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    25563    animals_animal_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.animals_animal_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.animals_animal_customer_id_seq;
       public          postgres    false    217            0           0    0    animals_animal_customer_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.animals_animal_customer_id_seq OWNED BY public.animals.animal_customer_id;
          public          postgres    false    216            �            1259    25562    animals_animal_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.animals_animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.animals_animal_id_seq;
       public          postgres    false    217            1           0    0    animals_animal_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.animals_animal_id_seq OWNED BY public.animals.animal_id;
          public          postgres    false    215            �            1259    25576    appointments    TABLE     �   CREATE TABLE public.appointments (
    appointment_date_id integer NOT NULL,
    appointment_date timestamp(6) without time zone,
    appointment_animal_id integer NOT NULL,
    appointment_doctor_id integer NOT NULL
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    25574 &   appointments_appointment_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.appointments_appointment_animal_id_seq;
       public          postgres    false    221            2           0    0 &   appointments_appointment_animal_id_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.appointments_appointment_animal_id_seq OWNED BY public.appointments.appointment_animal_id;
          public          postgres    false    219            �            1259    25573 $   appointments_appointment_date_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_date_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public.appointments_appointment_date_id_seq;
       public          postgres    false    221            3           0    0 $   appointments_appointment_date_id_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public.appointments_appointment_date_id_seq OWNED BY public.appointments.appointment_date_id;
          public          postgres    false    218            �            1259    25575 &   appointments_appointment_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.appointments_appointment_doctor_id_seq;
       public          postgres    false    221            4           0    0 &   appointments_appointment_doctor_id_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.appointments_appointment_doctor_id_seq OWNED BY public.appointments.appointment_doctor_id;
          public          postgres    false    220            �            1259    25586    available_dates    TABLE     �   CREATE TABLE public.available_dates (
    available_date_id integer NOT NULL,
    available_date date,
    available_date_doctor_id integer NOT NULL
);
 #   DROP TABLE public.available_dates;
       public         heap    postgres    false            �            1259    25585 ,   available_dates_available_date_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_dates_available_date_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 C   DROP SEQUENCE public.available_dates_available_date_doctor_id_seq;
       public          postgres    false    224            5           0    0 ,   available_dates_available_date_doctor_id_seq    SEQUENCE OWNED BY     }   ALTER SEQUENCE public.available_dates_available_date_doctor_id_seq OWNED BY public.available_dates.available_date_doctor_id;
          public          postgres    false    223            �            1259    25584 %   available_dates_available_date_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_dates_available_date_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public.available_dates_available_date_id_seq;
       public          postgres    false    224            6           0    0 %   available_dates_available_date_id_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public.available_dates_available_date_id_seq OWNED BY public.available_dates.available_date_id;
          public          postgres    false    222            �            1259    25594 	   customers    TABLE       CREATE TABLE public.customers (
    customer_id bigint NOT NULL,
    customer_address character varying(255),
    customer_city character varying(255),
    customer_mail character varying(255),
    customer_name character varying(255),
    customer_phone character varying(255)
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    25593    customers_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.customers_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.customers_customer_id_seq;
       public          postgres    false    226            7           0    0    customers_customer_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.customers_customer_id_seq OWNED BY public.customers.customer_id;
          public          postgres    false    225            �            1259    25603    doctors    TABLE       CREATE TABLE public.doctors (
    doctor_id integer NOT NULL,
    doctor_address character varying(255),
    doctor_city character varying(255),
    doctor_mail character varying(255),
    doctor_name character varying(255),
    doctor_phone character varying(255)
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    25602    doctors_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.doctors_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.doctors_doctor_id_seq;
       public          postgres    false    228            8           0    0    doctors_doctor_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.doctors_doctor_id_seq OWNED BY public.doctors.doctor_id;
          public          postgres    false    227            �            1259    25647    vaccines    TABLE       CREATE TABLE public.vaccines (
    vaccine_id bigint NOT NULL,
    vaccine_code character varying(255),
    vaccine_name character varying(255),
    vaccine_protection_finish_date date,
    vaccine_protection_start_date date,
    vaccine_animal_id integer NOT NULL
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    25652    vaccines_vaccine_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_vaccine_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.vaccines_vaccine_animal_id_seq;
       public          postgres    false    229            9           0    0    vaccines_vaccine_animal_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.vaccines_vaccine_animal_id_seq OWNED BY public.vaccines.vaccine_animal_id;
          public          postgres    false    230            �            1259    25653    vaccines_vaccine_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_vaccine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.vaccines_vaccine_id_seq;
       public          postgres    false    229            :           0    0    vaccines_vaccine_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.vaccines_vaccine_id_seq OWNED BY public.vaccines.vaccine_id;
          public          postgres    false    231            n           2604    25717    animals animal_id    DEFAULT     v   ALTER TABLE ONLY public.animals ALTER COLUMN animal_id SET DEFAULT nextval('public.animals_animal_id_seq'::regclass);
 @   ALTER TABLE public.animals ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    217    215    217            o           2604    25718    animals animal_customer_id    DEFAULT     �   ALTER TABLE ONLY public.animals ALTER COLUMN animal_customer_id SET DEFAULT nextval('public.animals_animal_customer_id_seq'::regclass);
 I   ALTER TABLE public.animals ALTER COLUMN animal_customer_id DROP DEFAULT;
       public          postgres    false    217    216    217            p           2604    25719     appointments appointment_date_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_date_id SET DEFAULT nextval('public.appointments_appointment_date_id_seq'::regclass);
 O   ALTER TABLE public.appointments ALTER COLUMN appointment_date_id DROP DEFAULT;
       public          postgres    false    221    218    221            q           2604    25720 "   appointments appointment_animal_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_animal_id SET DEFAULT nextval('public.appointments_appointment_animal_id_seq'::regclass);
 Q   ALTER TABLE public.appointments ALTER COLUMN appointment_animal_id DROP DEFAULT;
       public          postgres    false    221    219    221            r           2604    25721 "   appointments appointment_doctor_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_doctor_id SET DEFAULT nextval('public.appointments_appointment_doctor_id_seq'::regclass);
 Q   ALTER TABLE public.appointments ALTER COLUMN appointment_doctor_id DROP DEFAULT;
       public          postgres    false    221    220    221            s           2604    25722 !   available_dates available_date_id    DEFAULT     �   ALTER TABLE ONLY public.available_dates ALTER COLUMN available_date_id SET DEFAULT nextval('public.available_dates_available_date_id_seq'::regclass);
 P   ALTER TABLE public.available_dates ALTER COLUMN available_date_id DROP DEFAULT;
       public          postgres    false    222    224    224            t           2604    25723 (   available_dates available_date_doctor_id    DEFAULT     �   ALTER TABLE ONLY public.available_dates ALTER COLUMN available_date_doctor_id SET DEFAULT nextval('public.available_dates_available_date_doctor_id_seq'::regclass);
 W   ALTER TABLE public.available_dates ALTER COLUMN available_date_doctor_id DROP DEFAULT;
       public          postgres    false    224    223    224            u           2604    25724    customers customer_id    DEFAULT     ~   ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customers_customer_id_seq'::regclass);
 D   ALTER TABLE public.customers ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    225    226    226            v           2604    25725    doctors doctor_id    DEFAULT     v   ALTER TABLE ONLY public.doctors ALTER COLUMN doctor_id SET DEFAULT nextval('public.doctors_doctor_id_seq'::regclass);
 @   ALTER TABLE public.doctors ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    227    228    228            w           2604    25726    vaccines vaccine_id    DEFAULT     z   ALTER TABLE ONLY public.vaccines ALTER COLUMN vaccine_id SET DEFAULT nextval('public.vaccines_vaccine_id_seq'::regclass);
 B   ALTER TABLE public.vaccines ALTER COLUMN vaccine_id DROP DEFAULT;
       public          postgres    false    231    229            x           2604    25727    vaccines vaccine_animal_id    DEFAULT     �   ALTER TABLE ONLY public.vaccines ALTER COLUMN vaccine_animal_id SET DEFAULT nextval('public.vaccines_vaccine_animal_id_seq'::regclass);
 I   ALTER TABLE public.vaccines ALTER COLUMN vaccine_animal_id DROP DEFAULT;
       public          postgres    false    230    229                      0    25564    animals 
   TABLE DATA           �   COPY public.animals (animal_id, animal_breed, animal_colour, animal_date_of_birth, animal_gender, animal_name, animal_species, animal_customer_id) FROM stdin;
    public          postgres    false    217   �Y                 0    25576    appointments 
   TABLE DATA           {   COPY public.appointments (appointment_date_id, appointment_date, appointment_animal_id, appointment_doctor_id) FROM stdin;
    public          postgres    false    221   �Z       "          0    25586    available_dates 
   TABLE DATA           f   COPY public.available_dates (available_date_id, available_date, available_date_doctor_id) FROM stdin;
    public          postgres    false    224   $[       $          0    25594 	   customers 
   TABLE DATA              COPY public.customers (customer_id, customer_address, customer_city, customer_mail, customer_name, customer_phone) FROM stdin;
    public          postgres    false    226   �[       &          0    25603    doctors 
   TABLE DATA           q   COPY public.doctors (doctor_id, doctor_address, doctor_city, doctor_mail, doctor_name, doctor_phone) FROM stdin;
    public          postgres    false    228   �\       '          0    25647    vaccines 
   TABLE DATA           �   COPY public.vaccines (vaccine_id, vaccine_code, vaccine_name, vaccine_protection_finish_date, vaccine_protection_start_date, vaccine_animal_id) FROM stdin;
    public          postgres    false    229   /^       ;           0    0    animals_animal_customer_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.animals_animal_customer_id_seq', 1, false);
          public          postgres    false    216            <           0    0    animals_animal_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.animals_animal_id_seq', 7, true);
          public          postgres    false    215            =           0    0 &   appointments_appointment_animal_id_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public.appointments_appointment_animal_id_seq', 1, false);
          public          postgres    false    219            >           0    0 $   appointments_appointment_date_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.appointments_appointment_date_id_seq', 7, true);
          public          postgres    false    218            ?           0    0 &   appointments_appointment_doctor_id_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public.appointments_appointment_doctor_id_seq', 1, false);
          public          postgres    false    220            @           0    0 ,   available_dates_available_date_doctor_id_seq    SEQUENCE SET     [   SELECT pg_catalog.setval('public.available_dates_available_date_doctor_id_seq', 1, false);
          public          postgres    false    223            A           0    0 %   available_dates_available_date_id_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public.available_dates_available_date_id_seq', 15, true);
          public          postgres    false    222            B           0    0    customers_customer_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.customers_customer_id_seq', 7, true);
          public          postgres    false    225            C           0    0    doctors_doctor_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.doctors_doctor_id_seq', 6, true);
          public          postgres    false    227            D           0    0    vaccines_vaccine_animal_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.vaccines_vaccine_animal_id_seq', 1, false);
          public          postgres    false    230            E           0    0    vaccines_vaccine_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.vaccines_vaccine_id_seq', 6, true);
          public          postgres    false    231            z           2606    25572    animals animals_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (animal_id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    217            |           2606    25583    appointments appointments_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (appointment_date_id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    221            ~           2606    25592 $   available_dates available_dates_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT available_dates_pkey PRIMARY KEY (available_date_id);
 N   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT available_dates_pkey;
       public            postgres    false    224            �           2606    25601    customers customers_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    226            �           2606    25610    doctors doctors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (doctor_id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    228            �           2606    25666    vaccines vaccines_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (vaccine_id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    229            �           2606    25632 '   appointments fk27d0xcbajwaeeun2doojsae4    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk27d0xcbajwaeeun2doojsae4 FOREIGN KEY (appointment_doctor_id) REFERENCES public.doctors(doctor_id);
 Q   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk27d0xcbajwaeeun2doojsae4;
       public          postgres    false    4738    228    221            �           2606    25667 $   vaccines fkekhfjmpsduds8nnilqe9b467v    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT fkekhfjmpsduds8nnilqe9b467v FOREIGN KEY (vaccine_animal_id) REFERENCES public.animals(animal_id);
 N   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT fkekhfjmpsduds8nnilqe9b467v;
       public          postgres    false    229    4730    217            �           2606    25637 *   available_dates fkf7jtwolyhaj07c4oh0j4pncb    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT fkf7jtwolyhaj07c4oh0j4pncb FOREIGN KEY (available_date_doctor_id) REFERENCES public.doctors(doctor_id);
 T   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT fkf7jtwolyhaj07c4oh0j4pncb;
       public          postgres    false    228    224    4738            �           2606    25622 #   animals fknjsvd8kplxqmf48ybxayrx6ru    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fknjsvd8kplxqmf48ybxayrx6ru FOREIGN KEY (animal_customer_id) REFERENCES public.customers(customer_id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fknjsvd8kplxqmf48ybxayrx6ru;
       public          postgres    false    217    226    4736            �           2606    25627 (   appointments fko4t945rb708af9ry6syof7bwt    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fko4t945rb708af9ry6syof7bwt FOREIGN KEY (appointment_animal_id) REFERENCES public.animals(animal_id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fko4t945rb708af9ry6syof7bwt;
       public          postgres    false    221    4730    217                 x�M��j�0���S�<l'M�k[�RV��.�(�hL�8�X�~N��@�_?ߏ�}o��`��cZ�W��P+8`O���ΟA1�ŁF����Go�ϵ2�x�a1T7���(�*l�q6=�.f-d)�L��͘��X���^�+|uv"�LO��B*!?y��m�9[���z�L�3��B,�RB����C���X{
:�tt�(h��7�A�P:yj���+�Ha��R��8+{~�`�i�
�����ji�         R   x�e��	�0����4`��d\K��#zE�y˦��%��%\��b�ic#�����JmWK�R��,�]�C|J�j�K��� /�%      "   T   x�Eα�0���%<�N���s ���QYs�� �,���9�e.q�J�����m*���%H�Ѡǔ�ϔ�ה�ߔ�� �ʍ&G      $   W  x�]��n�0@�㯘HD魥��Us@�z��q� U���ғ�g��2��פ�}`�������|���꾽�o��i�-,���ʲL�{2-gs��,xo�h�;�q;6�[K� ������漢'�rZ�����oN���nh���%6�g��l}!�H�y6gj
�$�W��<m���^Bv��jJ�t���UG�w�*�&�H����2y�+r,a�j8kcd�������&�h�^Ɖ�AUU�СiqᏆO�P�Ç@��]��}�$-�^
��_"�t.,ʥ�DZ��9�oyK�o*5S��[r�B�i<��cі�D\��T)��R��      &   0  x�]��N�0E�㯘�ռ�tGC�P�����IF�i쩒���,�W�s�GWA'����~�Fx�+�s�On�j���K�SG�fq���4�˼X�D~�ug�$[p��� �35���������>pȲL�s����>��B�LpߚZ*�Th5���J�p��aQ�r��2���H!�E�b�+��<�~��ժ��:��=�2`H�D�y.��,��G�{�Վ`g�5`M�j���t��~"|�EǱ,�B���9�K��-�|������C�]m��a�Sk�j�����*
������PB�o$:�c      '   �   x�m̩AEQ]�/Ej�ɾjC&�/����]q�����[�?�weu&�OZ����|�Ɠ&5��r�!;�2����-˕GiҪd!�*kXo�?�����a�����MF�B�>�t����]5�     